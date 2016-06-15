package com.makarevich.dao.match.model;

import com.makarevich.dao.action.model.Action;
import com.makarevich.dao.actionresult.model.ActionResult;
import com.makarevich.dao.player.model.Player;
import com.makarevich.dao.subaction.model.SubAction;

public class RallyItem {

    private Long id;
    private Player player;
    private Action action;
    private SubAction subAction;
    private ActionResult actionResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public SubAction getSubAction() {
        return subAction;
    }

    public void setSubAction(SubAction subAction) {
        this.subAction = subAction;
    }

    public ActionResult getActionResult() {
        return actionResult;
    }

    public void setActionResult(ActionResult actionResult) {
        this.actionResult = actionResult;
    }
}
