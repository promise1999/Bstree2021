//This is the MainController class

package com.finalsprint.bstree.controller;
import com.finalsprint.bstree.model.AVLTree;
import com.finalsprint.bstree.model.FinalSubmit;
import com.finalsprint.bstree.repository.SubmitRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MasterController {

    @Autowired
    private SubmitRepository submitRepository;

    // Get submit page
    @GetMapping(path = "/finalSubmit")
    public String getSubmitPage(Model model) {
        FinalSubmit finalSubmit = new FinalSubmit();
        model.addAttribute("finalSubmit", finalSubmit);
        return "finalSubmit";
    }

    // Post submit
    @PostMapping(path = "/finalSubmit")
    public String submitForm(@ModelAttribute("finalSubmit") FinalSubmit finalSubmit, Model model, AVLTree tree, JSONObject bTree) {
        FinalSubmit listFinalSubmit = new FinalSubmit();
//        submitRepository.insertWithEntityManager(new Submit(submit.getNumber1(), submit.getNumber2(),
//                submit.getNumber3(), submit.getNumber4(), submit.getNumber5(), submit.getNumber6(),
//                submit.getNumber7(), submit.getNumber8(), submit.getNumber9()));
        model.addAttribute("listSubmit", listFinalSubmit);
        System.out.println("#######" + listFinalSubmit);
        tree.insert(finalSubmit.getNumber1());
        tree.insert(finalSubmit.getNumber2());
        tree.insert(finalSubmit.getNumber3());
        tree.insert(finalSubmit.getNumber4());
        tree.insert(finalSubmit.getNumber5());
        tree.insert(finalSubmit.getNumber6());
        tree.insert(finalSubmit.getNumber7());
        tree.insert(finalSubmit.getNumber8());
        tree.insert(finalSubmit.getNumber9());
        tree.insert(finalSubmit.getNumber10());
        System.out.println(tree);
        bTree.put("tree", tree);
        System.out.println(bTree);
        return "results";
    }
}
