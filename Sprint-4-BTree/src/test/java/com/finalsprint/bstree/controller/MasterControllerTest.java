package com.finalsprint.bstree.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.finalsprint.bstree.model.AVLTree;
import com.finalsprint.bstree.model.FinalSubmit;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

class MasterControllerTest {
    @Test
    void testGetSubmitPage() {
        MasterController mainController = new MasterController();
        assertEquals("submit", mainController.getSubmitPage(new ConcurrentModel()));
    }

    @Test
    void testSubmitForm() throws JSONException {
        MasterController mainController = new MasterController();

        FinalSubmit finalSubmit = new FinalSubmit();
        finalSubmit.setNumber5(10);
        finalSubmit.setNumber6(10);
        finalSubmit.setNumber3(10);
        finalSubmit.setNumber4(10);
        finalSubmit.setNumber9(10);
        finalSubmit.setNumber7(10);
        finalSubmit.setNumber8(10);
        finalSubmit.setNumber1(10);
        finalSubmit.setNumber2(10);
        finalSubmit.setNumber10(10);
        ConcurrentModel model = new ConcurrentModel();
        AVLTree avlTree = mock(AVLTree.class);
        doNothing().when(avlTree).insert(anyInt());
        JSONObject toJSONObjectResult = HTTP.toJSONObject("https://example.org/example");
        assertEquals("results", mainController.submitForm(finalSubmit, model, avlTree, toJSONObjectResult));
        verify(avlTree, atLeast(1)).insert(anyInt());
        assertEquals(4, toJSONObjectResult.length());
    }

    @Test
    void testSubmitForm2() throws JSONException {
        MasterController masterController = new MasterController();

        FinalSubmit finalSubmit = new FinalSubmit();
        finalSubmit.setNumber5(10);
        finalSubmit.setNumber6(10);
        finalSubmit.setNumber3(10);
        finalSubmit.setNumber4(10);
        finalSubmit.setNumber9(10);
        finalSubmit.setNumber7(10);
        finalSubmit.setNumber8(10);
        finalSubmit.setNumber1(10);
        finalSubmit.setNumber2(10);
        finalSubmit.setNumber10(10);
        ConcurrentModel model = new ConcurrentModel();
        AVLTree avlTree = mock(AVLTree.class);
        doNothing().when(avlTree).insert(anyInt());
        JSONObject jsonObject = mock(JSONObject.class);
        when(jsonObject.put((String) any(), (Object) any())).thenReturn(HTTP.toJSONObject("https://example.org/example"));
        assertEquals("results", masterController.submitForm(finalSubmit, model, avlTree, jsonObject));
        verify(avlTree, atLeast(1)).insert(anyInt());
        verify(jsonObject).put((String) any(), (Object) any());
    }
}

