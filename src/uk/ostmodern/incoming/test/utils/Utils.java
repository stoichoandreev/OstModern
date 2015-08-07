package uk.ostmodern.incoming.test.utils;

import uk.ostmodern.incoming.test.api.gson_models.ResponseImageModel;
import uk.ostmodern.incoming.test.api.gson_models.SetsModel;
import uk.ostmodern.incoming.test.constants.Preferences;
import uk.ostmodern.incoming.test.models.CardViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sniper on 8/15/15.
 */
public class Utils {
    public static List<CardViewModel> createUsefulSetModels(SetsModel[] allData,HashMap<String,ResponseImageModel> allImages){
        List<CardViewModel> allItems = new ArrayList<CardViewModel>(allData.length);
        int i =0;
        for (SetsModel setModel : allData){
//          we can remove in active items from the list
//            if(!includeInActive && !setModel.isActive()) continue;

            CardViewModel cardViewModel = new CardViewModel();
            cardViewModel.setTitle(setModel.getTitle());
            cardViewModel.setSummary(setModel.getSummary());
            cardViewModel.setCashedFilmCount(setModel.getCashedFilmCount());
            cardViewModel.setPublishDate(convertServerDateToApplicationDateFormat(setModel.getPublishOn()));
            cardViewModel.setHasPrice(setModel.isHasPrice());
            cardViewModel.setIsActive(setModel.isActive());
            cardViewModel.setBody(setModel.getFormattedBody());
            cardViewModel.setQuote(setModel.getQuote());
            cardViewModel.setImage(allImages.get(setModel.getuId()).getUrl());
//            cardViewModel.setImage(cardViewModel.getDefaultImage(i));
            cardViewModel.setItems(setModel.getItems());


            allItems.add(cardViewModel);
            i++;
        }
        return allItems;
    }
    public static String convertServerDateToApplicationDateFormat(String dateToBeConvert){
        SimpleDateFormat sdf = new SimpleDateFormat(Preferences.SERVER_DATE_FORMAT);
        Date serverDate = null;
        try {
            serverDate = sdf.parse(dateToBeConvert);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(Preferences.APPLICATION_DATE_FORMAT);
        return formatter.format(serverDate);
    }
}
