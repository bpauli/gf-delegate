package com.mysite.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import com.adobe.cq.wcm.core.components.models.Title;

@Model(adaptables = SlingHttpServletRequest.class,
       resourceType = CustomTitle.RESOURCE_TYPE)
public class CustomTitle implements Title {

    protected static final String RESOURCE_TYPE = "mysite/components/title";

    @Self
    @Via(type = ResourceSuperType.class)
    private Title delegate;

    @Override
    public String getText() {
        return delegate.getText() + " Override";
    }

    public String getExtendedText() {
        return delegate.getText() + " Extended";
    }
}
