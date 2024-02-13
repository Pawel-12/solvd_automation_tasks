package com.solvd.laba.block4.apitest;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api.url}/photos/${photo.id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "photos/patch/patch_photo_rq.json")
@ResponseTemplatePath(path = "photos/patch/patch_photo_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchPhoto extends AbstractApiMethodV2 {
    public PatchPhoto(Integer id) {
        replaceUrlPlaceholder("photo.id", id.toString());
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
