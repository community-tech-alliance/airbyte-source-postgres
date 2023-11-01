
package io.airbyte.integrations.source.postgres.internal.models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Postgres Models
 * <p>
 * Postgres Models
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "state_type",
    "xmin_state",
    "ctid_state",
    "cursor_based_state"
})
@Generated("jsonschema2pojo")
public class InternalModels {

    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    @JsonPropertyDescription("Enum to define the sync mode of state.")
    private InternalModels.StateType stateType;
    @JsonProperty("xmin_state")
    private XminStatus xminState;
    @JsonProperty("ctid_state")
    private CtidStatus ctidState;
    @JsonProperty("cursor_based_state")
    private CursorBasedStatus cursorBasedState;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    public InternalModels.StateType getStateType() {
        return stateType;
    }

    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    public void setStateType(InternalModels.StateType stateType) {
        this.stateType = stateType;
    }

    public InternalModels withStateType(InternalModels.StateType stateType) {
        this.stateType = stateType;
        return this;
    }

    @JsonProperty("xmin_state")
    public XminStatus getXminState() {
        return xminState;
    }

    @JsonProperty("xmin_state")
    public void setXminState(XminStatus xminState) {
        this.xminState = xminState;
    }

    public InternalModels withXminState(XminStatus xminState) {
        this.xminState = xminState;
        return this;
    }

    @JsonProperty("ctid_state")
    public CtidStatus getCtidState() {
        return ctidState;
    }

    @JsonProperty("ctid_state")
    public void setCtidState(CtidStatus ctidState) {
        this.ctidState = ctidState;
    }

    public InternalModels withCtidState(CtidStatus ctidState) {
        this.ctidState = ctidState;
        return this;
    }

    @JsonProperty("cursor_based_state")
    public CursorBasedStatus getCursorBasedState() {
        return cursorBasedState;
    }

    @JsonProperty("cursor_based_state")
    public void setCursorBasedState(CursorBasedStatus cursorBasedState) {
        this.cursorBasedState = cursorBasedState;
    }

    public InternalModels withCursorBasedState(CursorBasedStatus cursorBasedState) {
        this.cursorBasedState = cursorBasedState;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public InternalModels withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InternalModels.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("stateType");
        sb.append('=');
        sb.append(((this.stateType == null)?"<null>":this.stateType));
        sb.append(',');
        sb.append("xminState");
        sb.append('=');
        sb.append(((this.xminState == null)?"<null>":this.xminState));
        sb.append(',');
        sb.append("ctidState");
        sb.append('=');
        sb.append(((this.ctidState == null)?"<null>":this.ctidState));
        sb.append(',');
        sb.append("cursorBasedState");
        sb.append('=');
        sb.append(((this.cursorBasedState == null)?"<null>":this.cursorBasedState));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.xminState == null)? 0 :this.xminState.hashCode()));
        result = ((result* 31)+((this.cursorBasedState == null)? 0 :this.cursorBasedState.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.stateType == null)? 0 :this.stateType.hashCode()));
        result = ((result* 31)+((this.ctidState == null)? 0 :this.ctidState.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InternalModels) == false) {
            return false;
        }
        InternalModels rhs = ((InternalModels) other);
        return ((((((this.xminState == rhs.xminState)||((this.xminState!= null)&&this.xminState.equals(rhs.xminState)))&&((this.cursorBasedState == rhs.cursorBasedState)||((this.cursorBasedState!= null)&&this.cursorBasedState.equals(rhs.cursorBasedState))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.stateType == rhs.stateType)||((this.stateType!= null)&&this.stateType.equals(rhs.stateType))))&&((this.ctidState == rhs.ctidState)||((this.ctidState!= null)&&this.ctidState.equals(rhs.ctidState))));
    }


    /**
     * Enum to define the sync mode of state.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum StateType {

        CURSOR_BASED("cursor_based"),
        XMIN("xmin"),
        CTID("ctid");
        private final String value;
        private final static Map<String, InternalModels.StateType> CONSTANTS = new HashMap<String, InternalModels.StateType>();

        static {
            for (InternalModels.StateType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        StateType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static InternalModels.StateType fromValue(String value) {
            InternalModels.StateType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
