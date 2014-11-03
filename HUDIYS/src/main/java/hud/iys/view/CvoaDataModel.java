package hud.iys.view;

import java.util.List;
import javax.faces.model.ListDataModel;
import hud.iys.model.Cvoa;
import org.primefaces.model.SelectableDataModel;
 
public class CvoaDataModel extends ListDataModel<Cvoa> implements SelectableDataModel<Cvoa> {  
 
    public CvoaDataModel() {
    }
 
    public CvoaDataModel(List<Cvoa> data) {
        super(data);
    }
     
    @Override
    public Cvoa getRowData(String rowKey) {
         
        List<Cvoa> cVOAler = (List<Cvoa>) getWrappedData();
         
        for(Cvoa cVOA : cVOAler) {
            if((Long.toString(cVOA.getCvoaId())).equals(rowKey))
                return cVOA;
        }
         
        return null;
    }
 
    @Override
    public Object getRowKey(Cvoa cVOA) {
        return cVOA.getCvoaId();
    }
}