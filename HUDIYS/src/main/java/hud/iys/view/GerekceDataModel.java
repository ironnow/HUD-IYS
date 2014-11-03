package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Gerekce;
import org.primefaces.model.SelectableDataModel;
 
public class GerekceDataModel extends ListDataModel<Gerekce> implements SelectableDataModel<Gerekce> {  
 
    public GerekceDataModel() {
    }
 
    public GerekceDataModel(List<Gerekce> data) {
        super(data);
    }
     
    @Override
    public Gerekce getRowData(String rowKey) {
         
        List<Gerekce> yonetmelikler = (List<Gerekce>) getWrappedData();
         
        for(Gerekce yonetmelik : yonetmelikler) {
            if((Long.toString(yonetmelik.getGerekceId())).equals(rowKey))
                return yonetmelik;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Gerekce yonetmelik) {
        return yonetmelik.getGerekceId();
    }
}