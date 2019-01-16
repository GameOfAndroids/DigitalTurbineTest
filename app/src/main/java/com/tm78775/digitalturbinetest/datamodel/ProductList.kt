package com.tm78775.digitalturbinetest.datamodel

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name="ads")
class ProductList {
    @set:ElementList(name="ad", required = false) @get:ElementList(name="ad", required = false) var products: ArrayList<Product>? = null
}

@Root(name="ad")
class Product {
    @set:Element @get:Element var appId:                 String? = null
    @set:Element @get:Element var appPrivacyPolicyUrl:   String? = null
    @set:Element @get:Element var averageRatingImageURL: String? = null
    @set:Element @get:Element var bidRate:               Double? = null
    @set:Element @get:Element var billingTypeId:         Int?    = null
    @set:Element @get:Element var callToAction:          String? = null
    @set:Element @get:Element var campaignDisplayOrder:  Int?    = null
    @set:Element @get:Element var campaignId:            Int?    = null
    @set:Element @get:Element var campaignTypeId:        Int?    = null
    @set:Element @get:Element var categoryName:          String? = null
    @set:Element @get:Element var clickProxyURL:         String? = null
    @set:Element @get:Element var creativeId:            Int?    = null
    @set:Element @get:Element var homeScreen:            Boolean? = null
    @set:Element @get:Element var impressionTrackingURL: String? = null
    @set:Element @get:Element var isRandomPick:          Boolean? = null
    @set:Element @get:Element var minOSVersion:          String? = null
    @set:Element @get:Element var numberOfRatings:       String? = null
    @set:Element @get:Element var productDescription:    String? = null
    @set:Element @get:Element var productId:             Int?    = null
    @set:Element @get:Element var productName:           String? = null
    @set:Element @get:Element var productThumbnail:      String? = null
    @set:Element @get:Element var rating:                String? = null
}