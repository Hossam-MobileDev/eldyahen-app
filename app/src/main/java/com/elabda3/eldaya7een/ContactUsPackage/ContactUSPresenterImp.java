package com.elabda3.eldaya7een.ContactUsPackage;


import com.elabda3.eldaya7een.model.SocialDataModel;

/**
 * Created by ebda3-mint on 10/10/17.
 */

public class ContactUSPresenterImp implements ContactUsPresenter, ContactUsModel.Listner {

    ContactUsModelImp contactUsModelImp;
    ContactUsView contactUsView;
    SocialDataModel socialDataModel;

    public ContactUSPresenterImp(ContactUsView contactUsView) {
        this.contactUsView = contactUsView;
        contactUsModelImp=new ContactUsModelImp();
    }

    @Override
    public void setContactData(String name, String email, String comment) {

        contactUsModelImp.sendContactToServer(name,email,comment,this);
    }

    @Override
    public void setSocialUrl(String url) {

        contactUsModelImp.getSocail(url,this);
    }

    @Override
    public void openFaceUrl() {

        if(socialDataModel != null){
            contactUsView.openFaceUrl(socialDataModel.getFacebook());
        }
    }

    @Override
    public void openYoutubeUrl() {

        if(socialDataModel != null){
            contactUsView.openYoutubeUrl(socialDataModel.getYoutube());
        }
    }

    @Override
    public void openInstaUrl() {

        if(socialDataModel != null){
            contactUsView.openInstaUrl(socialDataModel.getInstagram());
        }
    }

    @Override
    public void openTwitterUrl() {

        if(socialDataModel != null){
            contactUsView.openTwitterUrl(socialDataModel.getTwitter());
        }
    }



    @Override
    public void onSuccess(String msg, boolean statusDone) {
        contactUsView.dismissProgress();
        if(statusDone){
            contactUsView.clearViews();
            contactUsView.showAlert(msg);
        }else{
            contactUsView.showAlert(msg);
        }
    }

    @Override
    public void onSocialSuccess(SocialDataModel socialDataModel) {
       this.socialDataModel=socialDataModel;
        if(socialDataModel != null){
            contactUsView.setPhoneNumber(socialDataModel.getLat(),socialDataModel.getLongX());
        }
    }

    @Override
    public void onSocialFailure(String msg) {

    }

    @Override
    public void onFailure(String msg) {

        contactUsView.dismissProgress();
        contactUsView.showAlert(msg);

    }
}
