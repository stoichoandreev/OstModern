package uk.ostmodern.incoming.test.utils;

import uk.ostmodern.incoming.test.constants.Preferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sniper on 2015.
 */
public class OstViewPagerUtils {
    /*
    * Method return array with positions for view pager, depending on @selectedPosition (selected position is for all data)
    * @ positionsCount - size of list with all data
     */
    public static int[] getStartingPositions(int selectedPosition,int positionsCount) {
        //prev - prevent index out of bound
        if (selectedPosition == 0 || selectedPosition == 1 || selectedPosition == 2) {//first,sec,third position is selected
            return createPositions(0,((positionsCount - selectedPosition) >= (Preferences.VIEW_PAGER_ITEMS_NUMBER -selectedPosition)) ?
                    (((selectedPosition + Preferences.VIEW_PAGER_ITEMS_NUMBER > positionsCount) ? (Preferences.VIEW_PAGER_ITEMS_NUMBER - selectedPosition) : Preferences.VIEW_PAGER_ITEMS_NUMBER)) : positionsCount);
        }
        //next - prevent index out of bound
        else if ((positionsCount - selectedPosition) == 1 || (positionsCount - selectedPosition) == 2 || (positionsCount - selectedPosition) == 3) {//last,last -1, last -2 position is selected
            return createPositions((((positionsCount - selectedPosition) - (Preferences.VIEW_PAGER_ITEMS_NUMBER - ((positionsCount - selectedPosition)))) >= 0) ? (Preferences.VIEW_PAGER_ITEMS_NUMBER - ((positionsCount - selectedPosition))) : (((selectedPosition / Preferences.VIEW_PAGER_ITEMS_NUMBER)*(Preferences.VIEW_PAGER_ITEMS_NUMBER)) + (positionsCount - selectedPosition - 1)),positionsCount);
        }
        else{//in all other cases we return normal array
            return createPositions((selectedPosition - Preferences.VIEW_PAGER_HALF_ITEMS) , (selectedPosition + Preferences.VIEW_PAGER_HALF_ITEMS + 1));
        }
    }
    public static int [] createPositions(int min,int max){
        List<Integer> positions = new ArrayList<Integer>();
        for(int i = min;i < max;i++){
            positions.add(i);
        }
        //convert list to primitive type array
        int[] array = new int[positions.size()];
        for(int i = 0; i < positions.size(); i++){
            array[i] = positions.get(i);
        }
        return array;
    }

    public static int getDefaultPositions(int selectedPosition,int positionsCount) {
        if (selectedPosition == 0 || selectedPosition == 1 || selectedPosition == 2) {
            return selectedPosition;
        }
        else if ((positionsCount - selectedPosition) == 1 || (positionsCount - selectedPosition) == 2 || (positionsCount - selectedPosition) == 3) {
            return ((selectedPosition/Preferences.VIEW_PAGER_ITEMS_NUMBER) * Preferences.VIEW_PAGER_ITEMS_NUMBER >= positionsCount) ? selectedPosition : ((selectedPosition/Preferences.VIEW_PAGER_ITEMS_NUMBER) * Preferences.VIEW_PAGER_ITEMS_NUMBER - ((positionsCount - selectedPosition) + 1));
        }
        else{
            return Preferences.VIEW_PAGER_HALF_ITEMS;
        }
    }
}
