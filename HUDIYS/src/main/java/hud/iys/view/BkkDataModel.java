package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Bkk;
import org.primefaces.model.SelectableDataModel;
 
public class BkkDataModel extends ListDataModel<Bkk> implements SelectableDataModel<Bkk> {  
 
    public BkkDataModel() {
    }
 
    public BkkDataModel(List<Bkk> data) {
        super(data);
    }
     
    @Override
    public Bkk getRowData(String rowKey) {
         
        List<Bkk> bkklar = (List<Bkk>) getWrappedData();
         
        for(Bkk bKK : bkklar) {
            if((Long.toString(bKK.getBkkId())).equals(rowKey))
                return bKK;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Bkk bKK) {
        return bKK.getBkkId();
    }
}