
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
import io.airbyte.integrations.source.relationaldb.models.DbStreamState;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "state_type",
    "version"
})
@Generated("jsonschema2pojo")
public class CursorBasedStatus
    extends DbStreamState
{

    /**
     * Enum to define the sync mode of state.
     * 
     */
    @JsonProperty("state_type")
    @JsonPropertyDescription("Enum to define the sync mode of state.")
    private io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType stateType;
    /**
     * Version of state.
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Version of state.")
    private Long version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    public CursorBasedStatus withStateType(io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType stateType) {
        this.stateType = stateType;
        return this;
    }

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

    public CursorBasedStatus withVersion(Long version) {
        this.version = version;
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

    public CursorBasedStatus withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CursorBasedStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        int baseLength = sb.length();
        String superString = super.toString();
        if (superString!= null) {
            int contentStart = superString.indexOf('[');
            int contentEnd = superString.lastIndexOf(']');
            if ((contentStart >= 0)&&(contentEnd >contentStart)) {
                sb.append(superString, (contentStart + 1), contentEnd);
            } else {
                sb.append(superString);
            }
        }
        if (sb.length()>baseLength) {
            sb.append(',');
        }
        sb.append("stateType");
        sb.append('=');
        sb.append(((this.stateType == null)?"<null>":this.stateType));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.stateType == null)? 0 :this.stateType.hashCode()));
        result = ((result* 31)+ super.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CursorBasedStatus) == false) {
            return false;
        }
        CursorBasedStatus rhs = ((CursorBasedStatus) other);
        return (((super.equals(rhs)&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.stateType == rhs.stateType)||((this.stateType!= null)&&this.stateType.equals(rhs.stateType))));
    }

}
