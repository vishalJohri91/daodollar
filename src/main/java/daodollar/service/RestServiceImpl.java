package daodollar.service;

import daodollar.model.*;
import daodollar.util.Parser;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestServiceImpl implements RestService {

    private Parent[] parentInputs;
    private Map<Integer,List<Child>> parentIdToChildrenMap;
    private static boolean dataLoaded;

    private void init() {
        if(!dataLoaded) {
            parentInputs = Parser.getParentData();
            parentIdToChildrenMap = Arrays.stream(Parser.getChildData())
                    .collect(Collectors.groupingBy(Child::getParentId));
            dataLoaded = true;
        }
    }

    @Override
    public List<ParentChildRelation> getAllParents(boolean isOutputSortedById) {

        init();
        List<ParentChildRelation> output = new ArrayList<>();
        if(isOutputSortedById) {
            Arrays.sort(parentInputs, (o1, o2) -> o1.getId().compareTo(o2.getId()));
        }
        for(Parent parent : parentInputs) {
            Double totalPaidAmount = 0.0;
            List<Child> children = parentIdToChildrenMap.get(parent.getId());
            if(children != null) {
                totalPaidAmount = children.stream().mapToDouble(Child::getPaidAmount).sum();
            }
            ParentChildRelation parentChildRelation = new ParentChildRelation();
            parentChildRelation.setId(parent.getId());
            parentChildRelation.setReceiver(parent.getReceiver());
            parentChildRelation.setSender(parent.getSender());
            parentChildRelation.setTotalAmount(parent.getTotalAmount());
            parentChildRelation.setTotalPaidAmount(totalPaidAmount);

            output.add(parentChildRelation);
        }

        return output;
    }

    @Override
    public List<ParentChildRelation> getAllChildren(Integer parentId) {

        init();
        List<ParentChildRelation> output = new ArrayList<>();
        List<Child> children = parentIdToChildrenMap.get(parentId);
        if(children != null) {
            Parent parent = Arrays.stream(parentInputs)
                    .filter(parent1 -> parent1.getId().equals(parentId)).findFirst().orElse(null);
            if(parent == null) {
                return output; //considering child always has a parent, this case is impossible
            }
            Collections.sort(children, new Comparator<Child>() {
                @Override
                public int compare(Child o1, Child o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            for(Child child : children) {
                ParentChildRelation parentChildRelation = new ParentChildRelation();
                parentChildRelation.setReceiver(parent.getReceiver());
                parentChildRelation.setSender(parent.getSender());
                parentChildRelation.setTotalAmount(parent.getTotalAmount());
                parentChildRelation.setId(child.getId());
                parentChildRelation.setTotalPaidAmount(child.getPaidAmount());

                output.add(parentChildRelation);
            }
        }

        return output;
    }

}
