package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Vkbda;
import org.primefaces.model.SelectableDataModel;
 
public class VkbdaDataModel extends ListDataModel<Vkbda> implements SelectableDataModel<Vkbda> {  
 
    public VkbdaDataModel() {
    }
 
    public VkbdaDataModel(List<Vkbda> data) {
        super(data);
    }
     
    @Override
    public Vkbda getRowData(String rowKey) {
         
        List<Vkbda> vKBDAlar = (List<Vkbda>) getWrappedData();
         
        for(Vkbda vKBDA : vKBDAlar) {
            if((Long.toString(vKBDA.getVkbdaId())).equals(rowKey))
                return vKBDA;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Vkbda vKBDA) {
        return vKBDA.getVkbdaId();
    }
}