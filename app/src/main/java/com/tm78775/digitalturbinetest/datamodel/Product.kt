package com.tm78775.digitalturbinetest.datamodel

import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import java.io.Serializable

@Path("ad")
@Root(name="ad", strict = false)
class Product: Serializable {
    @set:Element(required = false) @get:Element(required = false) var appId:                 String?  = null
    @set:Element(required = false) @get:Element(required = false) var appPrivacyPolicyUrl:   String?  = null
    @set:Element(required = false) @get:Element(required = false) var averageRatingImageURL: String?  = null
    @set:Element(required = false) @get:Element(required = false) var bidRate:               Double?  = null
    @set:Element(required = false) @get:Element(required = false) var billingTypeId:         Int?     = null
    @set:Element(required = false) @get:Element(required = false) var callToAction:          String?  = null
    @set:Element(required = false) @get:Element(required = false) var campaignDisplayOrder:  Int?     = null
    @set:Element(required = false) @get:Element(required = false) var campaignId:            Int?     = null
    @set:Element(required = false) @get:Element(required = false) var campaignTypeId:        Int?     = null
    @set:Element(required = false) @get:Element(required = false) var categoryName:          String?  = null
    @set:Element(required = false) @get:Element(required = false) var clickProxyURL:         String?  = null
    @set:Element(required = false) @get:Element(required = false) var creativeId:            Int?     = null
    @set:Element(required = false) @get:Element(required = false) var homeScreen:            Boolean? = null
    @set:Element(required = false) @get:Element(required = false) var impressionTrackingURL: String?  = null
    @set:Element(required = false) @get:Element(required = false) var isRandomPick:          Boolean? = null
    @set:Element(required = false) @get:Element(required = false) var minOSVersion:          String?  = null
    @set:Element(required = false) @get:Element(required = false) var numberOfRatings:       String?  = null
    @set:Element(required = false) @get:Element(required = false) var productDescription:    String?  = null
    @set:Element(required = false) @get:Element(required = false) var productId:             Int?     = null
    @set:Element(required = false) @get:Element(required = false) var productName:           String?  = null
    @set:Element(required = false) @get:Element(required = false) var productThumbnail:      String?  = null
    @set:Element(required = false) @get:Element(required = false) var rating:                String?  = null
}