package com.bkonecsni.logicgame.domain.map;

import com.bkonecsni.logicgame.domain.common.Item;
import com.bkonecsni.logicgame.domain.common.Point;
import com.bkonecsni.logicgame.domain.types.TypeStatement;
import com.bkonecsni.logicgame.domain.types.equation.Condition;
import com.bkonecsni.logicgame.domain.types.equation.Update;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonTile extends TileBase {

    protected List<TypeStatement> typeStatementList;

    public CommonTile(Point position, Point size, List<Item> itemList) {
        super(position, size, itemList);
        init();
    }

    public abstract void init();

    @Override
    public void handleState() {
        List<Update> updateList = findUpdateList();

        for (Update update : updateList) {
            update.execute(itemList);
        }
    }

    @Override
    public boolean isUnmutableType() {
        return false;
    }

    private List<Update> findUpdateList() {
        List<Update> updateList = new ArrayList<>();

        for (TypeStatement typeStatement : typeStatementList) {
            if (areAllConditionMatch(typeStatement.getConditionList())) {
                updateList = typeStatement.getUpdateList();
                break;
            }
        }

        return updateList;
    }

    private boolean areAllConditionMatch(List<Condition> conditionList){
        boolean areAllConditionMatch = true;

        for (Condition condition : conditionList) {
            if (!condition.isConditionMatch(itemList)) {
                areAllConditionMatch = false;
                break;
            }
        }

        return areAllConditionMatch;
    }

    public List<TypeStatement> getTypeStatementList() {
        return typeStatementList;
    }

    public void setTypeStatementList(List<TypeStatement> typeStatementList) {
        this.typeStatementList = typeStatementList;
    }
}
