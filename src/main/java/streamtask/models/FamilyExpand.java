package streamtask.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FamilyExpand {

    private List<PersonExpand> familyMembers;
}
