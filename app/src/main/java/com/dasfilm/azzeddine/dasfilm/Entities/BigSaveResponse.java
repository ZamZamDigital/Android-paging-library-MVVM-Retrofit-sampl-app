package com.dasfilm.azzeddine.dasfilm.Entities;

import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BigSaveResponse {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("affiliate_link")
    @Expose
    private Object affiliateLink;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("brand_id")
    @Expose
    private String brandId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("childcategory_id")
    @Expose
    private String childcategoryId;
    @SerializedName("attributes")
    @Expose
    private Object attributes;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("file")
    @Expose
    private Object file;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("size_qty")
    @Expose
    private String sizeQty;
    @SerializedName("size_price")
    @Expose
    private String sizePrice;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("previous_price")
    @Expose
    private String previousPrice;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("policy")
    @Expose
    private String policy;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("features")
    @Expose
    private String features;
    @SerializedName("colors")
    @Expose
    private String colors;
    @SerializedName("product_condition")
    @Expose
    private String productCondition;
    @SerializedName("ship")
    @Expose
    private Object ship;
    @SerializedName("is_meta")
    @Expose
    private String isMeta;
    @SerializedName("meta_tag")
    @Expose
    private List<String> metaTag = null;
    @SerializedName("meta_description")
    @Expose
    private String metaDescription;
    @SerializedName("youtube")
    @Expose
    private Object youtube;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("license")
    @Expose
    private String license;
    @SerializedName("license_qty")
    @Expose
    private String licenseQty;
    @SerializedName("link")
    @Expose
    private Object link;
    @SerializedName("platform")
    @Expose
    private Object platform;
    @SerializedName("region")
    @Expose
    private Object region;
    @SerializedName("licence_type")
    @Expose
    private Object licenceType;
    @SerializedName("measure")
    @Expose
    private Object measure;
    @SerializedName("featured")
    @Expose
    private String featured;
    @SerializedName("best")
    @Expose
    private String best;
    @SerializedName("top")
    @Expose
    private String top;
    @SerializedName("hot")
    @Expose
    private String hot;
    @SerializedName("latest")
    @Expose
    private String latest;
    @SerializedName("big")
    @Expose
    private String big;
    @SerializedName("trending")
    @Expose
    private String trending;
    @SerializedName("sale")
    @Expose
    private String sale;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_discount")
    @Expose
    private String isDiscount;
    @SerializedName("discount_date")
    @Expose
    private Object discountDate;
    @SerializedName("whole_sell_qty")
    @Expose
    private String wholeSellQty;
    @SerializedName("whole_sell_discount")
    @Expose
    private String wholeSellDiscount;
    @SerializedName("is_catalog")
    @Expose
    private String isCatalog;
    @SerializedName("catalog_id")
    @Expose
    private String catalogId;

    /**
     * No args constructor for use in serialization
     */
    public BigSaveResponse() {
    }

    /**
     * @param trending
     * @param big
     * @param featured
     * @param ship
     * @param sizeQty
     * @param isDiscount
     * @param type
     * @param metaDescription
     * @param sizePrice
     * @param productCondition
     * @param features
     * @param createdAt
     * @param childcategoryId
     * @param price
     * @param subcategoryId
     * @param details
     * @param licenseQty
     * @param id
     * @param sku
     * @param stock
     * @param slug
     * @param updatedAt
     * @param isCatalog
     * @param thumbnail
     * @param metaTag
     * @param affiliateLink
     * @param tags
     * @param license
     * @param measure
     * @param size
     * @param discountDate
     * @param brandId
     * @param name
     * @param region
     * @param status
     * @param youtube
     * @param color
     * @param link
     * @param best
     * @param hot
     * @param colors
     * @param platform
     * @param file
     * @param catalogId
     * @param top
     * @param licenceType
     * @param previousPrice
     * @param productType
     * @param views
     * @param policy
     * @param latest
     * @param wholeSellQty
     * @param wholeSellDiscount
     * @param photo
     * @param isMeta
     * @param userId
     * @param sale
     * @param attributes
     * @param categoryId
     */

    public static final DiffUtil.ItemCallback<BigSaveResponse> DIFF_CALL = new DiffUtil.ItemCallback<BigSaveResponse>() {
        @Override
        public boolean areItemsTheSame(BigSaveResponse oldItem, BigSaveResponse newItem) {
            return  oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(BigSaveResponse oldItem, BigSaveResponse newItem) {
            return  oldItem.id == newItem.id;
        }
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Object getAffiliateLink() {
        return affiliateLink;
    }

    public void setAffiliateLink(Object affiliateLink) {
        this.affiliateLink = affiliateLink;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getChildcategoryId() {
        return childcategoryId;
    }

    public void setChildcategoryId(String childcategoryId) {
        this.childcategoryId = childcategoryId;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        this.file = file;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeQty() {
        return sizeQty;
    }

    public void setSizeQty(String sizeQty) {
        this.sizeQty = sizeQty;
    }

    public String getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(String sizePrice) {
        this.sizePrice = sizePrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public Object getShip() {
        return ship;
    }

    public void setShip(Object ship) {
        this.ship = ship;
    }

    public String getIsMeta() {
        return isMeta;
    }

    public void setIsMeta(String isMeta) {
        this.isMeta = isMeta;
    }

    public List<String> getMetaTag() {
        return metaTag;
    }

    public void setMetaTag(List<String> metaTag) {
        this.metaTag = metaTag;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public Object getYoutube() {
        return youtube;
    }

    public void setYoutube(Object youtube) {
        this.youtube = youtube;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseQty() {
        return licenseQty;
    }

    public void setLicenseQty(String licenseQty) {
        this.licenseQty = licenseQty;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }

    public Object getPlatform() {
        return platform;
    }

    public void setPlatform(Object platform) {
        this.platform = platform;
    }

    public Object getRegion() {
        return region;
    }

    public void setRegion(Object region) {
        this.region = region;
    }

    public Object getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(Object licenceType) {
        this.licenceType = licenceType;
    }

    public Object getMeasure() {
        return measure;
    }

    public void setMeasure(Object measure) {
        this.measure = measure;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getTrending() {
        return trending;
    }

    public void setTrending(String trending) {
        this.trending = trending;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount;
    }

    public Object getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(Object discountDate) {
        this.discountDate = discountDate;
    }

    public String getWholeSellQty() {
        return wholeSellQty;
    }

    public void setWholeSellQty(String wholeSellQty) {
        this.wholeSellQty = wholeSellQty;
    }

    public String getWholeSellDiscount() {
        return wholeSellDiscount;
    }

    public void setWholeSellDiscount(String wholeSellDiscount) {
        this.wholeSellDiscount = wholeSellDiscount;
    }

    public String getIsCatalog() {
        return isCatalog;
    }

    public void setIsCatalog(String isCatalog) {
        this.isCatalog = isCatalog;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

}
