package com.solvd.laba.block4.apitest;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api.url}/photos/${photo.id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "photos/get/get_photo_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetPhotoById extends AbstractApiMethodV2 {
    public GetPhotoById(Integer id) {
        //super(null, "src/test/resources/photos/get_photo_rs.json");
        //replaceUrlPlaceholder("api.url", Configuration.getRequired("api.url"));

        replaceUrlPlaceholder("photo.id", id.toString());

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}

