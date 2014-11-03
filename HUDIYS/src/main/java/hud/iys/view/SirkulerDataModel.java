package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Sirkuler;
import org.primefaces.model.SelectableDataModel;
 
public class SirkulerDataModel extends ListDataModel<Sirkuler> implements SelectableDataModel<Sirkuler> {  
 
    public SirkulerDataModel() {
    }
 
    public SirkulerDataModel(List<Sirkuler> data) {
        super(data);
    }
     
    @Override
    public Sirkuler getRowData(String rowKey) {
         
        List<Sirkuler> yonetmelikler = (List<Sirkuler>) getWrappedData();
         
        for(Sirkuler yonetmelik : yonetmelikler) {
            if((Long.toString(yonetmelik.getSirkulerId())).equals(rowKey))
                return yonetmelik;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Sirkuler yonetmelik) {
        return yonetmelik.getSirkulerId();
    }
}