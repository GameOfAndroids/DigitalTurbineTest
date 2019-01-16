package com.tm78775.digitalturbinetest.datamodel

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

@Root(name="ads", strict = false)
class ProductList {
    @set:ElementList(name="ad", required = false, inline = true)
    @get:ElementList(name="ad", required = false, inline = true)
    var products: ArrayList<Product>? = null
}