package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.IcGenelge;
import org.primefaces.model.SelectableDataModel;
 
public class IcGenelgeDataModel extends ListDataModel<IcGenelge> implements SelectableDataModel<IcGenelge> {  
 
    public IcGenelgeDataModel() {
    }
 
    public IcGenelgeDataModel(List<IcGenelge> data) {
        super(data);
    }
     
    @Override
    public IcGenelge getRowData(String rowKey) {
         
        List<IcGenelge> icGenelgeler = (List<IcGenelge>) getWrappedData();
         
        for(IcGenelge icGenelge : icGenelgeler) {
            if((Long.toString(icGenelge.getIcGenelgeId())).equals(rowKey))
                return icGenelge;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(IcGenelge icGenelge) {
        return icGenelge.getIcGenelgeId();
    }
}