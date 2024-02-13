package com.solvd.laba.block4;

import com.jayway.jsonpath.JsonPath;
import com.solvd.laba.block4.apitest.GetPhotoById;
import com.solvd.laba.block4.apitest.GetPhotos;
import com.solvd.laba.block4.apitest.PatchPhoto;
import com.solvd.laba.block4.apitest.PostPhoto;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class APIPhotoTest implements IAbstractTest {

    @Test
    public void getPhotoById() {
        GetPhotoById api = new GetPhotoById(2);

        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test
    public void getAllPhotos() {
        GetPhotos api = new GetPhotos();

        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("photos/get/get_photos_schema.json");
    }

    @Test
    public void createPhoto() {
        PostPhoto api = new PostPhoto();

        api.setProperties("photos/photo.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test
    public void createPhotoFail() {
        PostPhoto api = new PostPhoto();

        api.setProperties("photos/photo.properties");
        api.getProperties().remove("title");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test
    public void patchPhoto() {
        PostPhoto api = new PostPhoto();

        api.setProperties("photos/photo.properties");
        Response response = api.callAPIExpectSuccess();
        api.validateResponse();

        Integer id = JsonPath.read(response.body().print(), "$.id");

        PatchPhoto patchApi = new PatchPhoto(id);
        patchApi.setProperties("photos/photo.properties");
        patchApi.addProperty("title", "newtitle");
        patchApi.addProperty("id", id);

        patchApi.callAPIExpectSuccess();
        patchApi.validateResponse();
    }
}
