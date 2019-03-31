package com.lovegis.pojo;

public class Sourcethree {
    private Integer rId;

    private String name;

    private String introduction;

    private String fileSize;

    private String downloadLink;

    private String downloadLinkOffical;

    private String icon;

    private Boolean cracking;

    private String uploadTime;

    private Integer downloadTimes;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink == null ? null : downloadLink.trim();
    }

    public String getDownloadLinkOffical() {
        return downloadLinkOffical;
    }

    public void setDownloadLinkOffical(String downloadLinkOffical) {
        this.downloadLinkOffical = downloadLinkOffical == null ? null : downloadLinkOffical.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Boolean getCracking() {
        return cracking;
    }

    public void setCracking(Boolean cracking) {
        this.cracking = cracking;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime == null ? null : uploadTime.trim();
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }
}