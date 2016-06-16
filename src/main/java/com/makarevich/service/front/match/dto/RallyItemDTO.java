package com.makarevich.service.front.match.dto;


public class RallyItemDTO {

    private Long id;
    private Long player;
    private String playerName;
    private Long action;
    private String actionName;
    private Long subAction;
    private String subActionName;
    private Long actionResult;
    private String actionResultName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getAction() {
        return action;
    }

    public void setAction(Long action) {
        this.action = action;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Long getSubAction() {
        return subAction;
    }

    public void setSubAction(Long subAction) {
        this.subAction = subAction;
    }

    public String getSubActionName() {
        return subActionName;
    }

    public void setSubActionName(String subActionName) {
        this.subActionName = subActionName;
    }

    public Long getActionResult() {
        return actionResult;
    }

    public void setActionResult(Long actionResult) {
        this.actionResult = actionResult;
    }

    public String getActionResultName() {
        return actionResultName;
    }

    public void setActionResultName(String actionResultName) {
        this.actionResultName = actionResultName;
    }
}
