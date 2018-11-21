package com.bkonecsni.logicgame.domain.types;

import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;

import java.util.List;

public class TypeStatement {

    private List<Condition> conditionList;

    private List<Update> updateList;

    public TypeStatement(List<Condition> conditionList, List<Update> updateList) {
        this.conditionList = conditionList;
        this.updateList = updateList;
    }

    public List<Condition> getConditionList() {
        return conditionList;
    }

    public void setConditionList(List<Condition> conditionList) {
        this.conditionList = conditionList;
    }

    public List<Update> getUpdateList() {
        return updateList;
    }

    public void setUpdateList(List<Update> updateList) {
        this.updateList = updateList;
    }
}
