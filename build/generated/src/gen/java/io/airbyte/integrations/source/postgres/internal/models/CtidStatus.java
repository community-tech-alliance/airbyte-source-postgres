
package io.airbyte.integrations.source.postgres.internal.models;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "state_type",
    "ctid",
    "incremental_state",
    "relation_filenode"
})
@Generated("jsonschema2pojo")
public class CtidStatus {

    /**
     * Version of state.
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Version of state.")
    private Long version;
    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    @JsonPropertyDescription("Enum to define the sync mode of state.")
    private io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType stateType;
    /**
     * ctid bookmark
     * 
     */
    @JsonProperty("ctid")
    @JsonPropertyDescription("ctid bookmark")
    private String ctid;
    /**
     * State to switch to after completion of ctid initial sync
     * 
     */
    @JsonProperty("incremental_state")
    @JsonPropertyDescription("State to switch to after completion of ctid initial sync")
    private JsonNode incrementalState;
    @JsonProperty("relation_filenode")
    private Long relationFilenode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * Version of state.
     * 
     */
    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    /**
     * Version of state.
     * 
     */
    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    public CtidStatus withVersion(Long version) {
        this.version = version;
        return this;
    }

    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    public io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType getStateType() {
        return stateType;
    }

    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    public void setStateType(io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType stateType) {
        this.stateType = stateType;
    }

    public CtidStatus withStateType(io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType stateType) {
        this.stateType = stateType;
        return this;
    }

    /**
     * ctid bookmark
     * 
     */
    @JsonProperty("ctid")
    public String getCtid() {
        return ctid;
    }

    /**
     * ctid bookmark
     * 
     */
    @JsonProperty("ctid")
    public void setCtid(String ctid) {
        this.ctid = ctid;
    }

    public CtidStatus withCtid(String ctid) {
        this.ctid = ctid;
        return this;
    }

    /**
     * State to switch to after completion of ctid initial sync
     * 
     */
    @JsonProperty("incremental_state")
    public JsonNode getIncrementalState() {
        return incrementalState;
    }

    /**
     * State to switch to after completion of ctid initial sync
     * 
     */
    @JsonProperty("incremental_state")
    public void setIncrementalState(JsonNode incrementalState) {
        this.incrementalState = incrementalState;
    }

    public CtidStatus withIncrementalState(JsonNode incrementalState) {
        this.incrementalState = incrementalState;
        return this;
    }

    @JsonProperty("relation_filenode")
    public Long getRelationFilenode() {
        return relationFilenode;
    }

    @JsonProperty("relation_filenode")
    public void setRelationFilenode(Long relationFilenode) {
        this.relationFilenode = relationFilenode;
    }

    public CtidStatus withRelationFilenode(Long relationFilenode) {
        this.relationFilenode = relationFilenode;
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

    public CtidStatus withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CtidStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("stateType");
        sb.append('=');
        sb.append(((this.stateType == null)?"<null>":this.stateType));
        sb.append(',');
        sb.append("ctid");
        sb.append('=');
        sb.append(((this.ctid == null)?"<null>":this.ctid));
        sb.append(',');
        sb.append("incrementalState");
        sb.append('=');
        sb.append(((this.incrementalState == null)?"<null>":this.incrementalState));
        sb.append(',');
        sb.append("relationFilenode");
        sb.append('=');
        sb.append(((this.relationFilenode == null)?"<null>":this.relationFilenode));
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
        result = ((result* 31)+((this.ctid == null)? 0 :this.ctid.hashCode()));
        result = ((result* 31)+((this.stateType == null)? 0 :this.stateType.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.relationFilenode == null)? 0 :this.relationFilenode.hashCode()));
        result = ((result* 31)+((this.incrementalState == null)? 0 :this.incrementalState.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CtidStatus) == false) {
            return false;
        }
        CtidStatus rhs = ((CtidStatus) other);
        return (((((((this.ctid == rhs.ctid)||((this.ctid!= null)&&this.ctid.equals(rhs.ctid)))&&((this.stateType == rhs.stateType)||((this.stateType!= null)&&this.stateType.equals(rhs.stateType))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.relationFilenode == rhs.relationFilenode)||((this.relationFilenode!= null)&&this.relationFilenode.equals(rhs.relationFilenode))))&&((this.incrementalState == rhs.incrementalState)||((this.incrementalState!= null)&&this.incrementalState.equals(rhs.incrementalState))));
    }

}
