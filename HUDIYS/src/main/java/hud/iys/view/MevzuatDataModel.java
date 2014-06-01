package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Mevzuat;
import org.primefaces.model.SelectableDataModel;
 
public class MevzuatDataModel extends ListDataModel<Mevzuat> implements SelectableDataModel<Mevzuat> {  
 
    public MevzuatDataModel() {
    }
 
    public MevzuatDataModel(List<Mevzuat> data) {
        super(data);
    }
     
    @Override
    public Mevzuat getRowData(String rowKey) {
         
        List<Mevzuat> mevzuatlar = (List<Mevzuat>) getWrappedData();
         
        for(Mevzuat mevzuat : mevzuatlar) {
            if((Long.toString(mevzuat.getMevzuatId())).equals(rowKey))
                return mevzuat;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Mevzuat mevzuat) {
        return mevzuat.getMevzuatId();
    }
}