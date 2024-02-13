package com.solvd.laba.block4.apitest;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api.url}/photos/", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "photos/post/post_photo_rq.json")
@ResponseTemplatePath(path = "photos/post/post_photo_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPhoto extends AbstractApiMethodV2 {
    public PostPhoto() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
