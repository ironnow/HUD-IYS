package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Yonetmelik;
import org.primefaces.model.SelectableDataModel;
 
public class YonetmelikDataModel extends ListDataModel<Yonetmelik> implements SelectableDataModel<Yonetmelik> {  
 
    public YonetmelikDataModel() {
    }
 
    public YonetmelikDataModel(List<Yonetmelik> data) {
        super(data);
    }
     
    @Override
    public Yonetmelik getRowData(String rowKey) {
         
        List<Yonetmelik> yonetmelikler = (List<Yonetmelik>) getWrappedData();
         
        for(Yonetmelik yonetmelik : yonetmelikler) {
            if((Long.toString(yonetmelik.getYonetmelikId())).equals(rowKey))
                return yonetmelik;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Yonetmelik yonetmelik) {
        return yonetmelik.getYonetmelikId();
    }
}