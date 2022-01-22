package daodollar.web;

import daodollar.model.ResponseData;
import daodollar.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping
public class RestController {

    @Autowired
    private RestService restService;

    @GetMapping("/parents")
    public ResponseData getParents(@RequestParam(value="sorted", defaultValue="false") boolean isSorted) {
        ResponseData responseData = new ResponseData();
        responseData.setData(restService.getAllParents(isSorted));

        return responseData;
    }

    @GetMapping("/children/{parentId}")
    public ResponseData getChildren(@PathVariable Integer parentId) {
        ResponseData responseData = new ResponseData();
        responseData.setData(restService.getAllChildren(parentId));

        return responseData;
    }
}
