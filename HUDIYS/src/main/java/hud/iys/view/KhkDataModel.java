package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Khk;
import org.primefaces.model.SelectableDataModel;
 
public class KhkDataModel extends ListDataModel<Khk> implements SelectableDataModel<Khk> {  
 
    public KhkDataModel() {
    }
 
    public KhkDataModel(List<Khk> data) {
        super(data);
    }
     
    @Override
    public Khk getRowData(String rowKey) {
         
        List<Khk> kHKlar = (List<Khk>) getWrappedData();
         
        for(Khk kHK : kHKlar) {
            if((Long.toString(kHK.getKhkId())).equals(rowKey))
                return kHK;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Khk kHK) {
        return kHK.getKhkId();
    }
}