package daodollar.service;

import daodollar.model.ParentChildRelation;

import java.util.List;

public interface RestService {

    List<ParentChildRelation> getAllParents(boolean isOutputSortedById);
    List<ParentChildRelation> getAllChildren(Integer parentId);
}
