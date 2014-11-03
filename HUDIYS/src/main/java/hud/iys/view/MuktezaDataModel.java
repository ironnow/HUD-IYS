package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Mukteza;
import org.primefaces.model.SelectableDataModel;
 
public class MuktezaDataModel extends ListDataModel<Mukteza> implements SelectableDataModel<Mukteza> {  
 
    public MuktezaDataModel() {
    }
 
    public MuktezaDataModel(List<Mukteza> data) {
        super(data);
    }
     
    @Override
    public Mukteza getRowData(String rowKey) {
         
        List<Mukteza> muktezalar = (List<Mukteza>) getWrappedData();
         
        for(Mukteza mukteza : muktezalar) {
            if((Long.toString(mukteza.getMuktezaId())).equals(rowKey))
                return mukteza;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Mukteza mukteza) {
        return mukteza.getMuktezaId();
    }
}