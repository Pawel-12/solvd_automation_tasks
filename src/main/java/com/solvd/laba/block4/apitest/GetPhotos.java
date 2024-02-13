package com.solvd.laba.block4.apitest;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api.url}/photos/", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "photos/get/get_photos_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetPhotos extends AbstractApiMethodV2 {
    public GetPhotos() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
