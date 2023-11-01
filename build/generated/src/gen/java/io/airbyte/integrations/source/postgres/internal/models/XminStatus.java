
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "version",
    "state_type",
    "num_wraparound",
    "xmin_xid_value",
    "xmin_raw_value"
})
@Generated("jsonschema2pojo")
public class XminStatus {

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
     * Number of times the Xmin value has wrapped around.
     * 
     */
    @JsonProperty("num_wraparound")
    @JsonPropertyDescription("Number of times the Xmin value has wrapped around.")
    private Long numWraparound;
    /**
     * The 32-bit xmin value associated with the xmin snapshot. This is the value that is ultimately written and recorded on every row.
     * 
     */
    @JsonProperty("xmin_xid_value")
    @JsonPropertyDescription("The 32-bit xmin value associated with the xmin snapshot. This is the value that is ultimately written and recorded on every row.")
    private Long xminXidValue;
    /**
     * The raw value of the xmin snapshot. If no wraparound has occurred, this should be the same as 2.
     * 
     */
    @JsonProperty("xmin_raw_value")
    @JsonPropertyDescription("The raw value of the xmin snapshot. If no wraparound has occurred, this should be the same as 2.")
    private Long xminRawValue;
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

    public XminStatus withVersion(Long version) {
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

    public XminStatus withStateType(io.airbyte.integrations.source.postgres.internal.models.InternalModels.StateType stateType) {
        this.stateType = stateType;
        return this;
    }

    /**
     * Number of times the Xmin value has wrapped around.
     * 
     */
    @JsonProperty("num_wraparound")
    public Long getNumWraparound() {
        return numWraparound;
    }

    /**
     * Number of times the Xmin value has wrapped around.
     * 
     */
    @JsonProperty("num_wraparound")
    public void setNumWraparound(Long numWraparound) {
        this.numWraparound = numWraparound;
    }

    public XminStatus withNumWraparound(Long numWraparound) {
        this.numWraparound = numWraparound;
        return this;
    }

    /**
     * The 32-bit xmin value associated with the xmin snapshot. This is the value that is ultimately written and recorded on every row.
     * 
     */
    @JsonProperty("xmin_xid_value")
    public Long getXminXidValue() {
        return xminXidValue;
    }

    /**
     * The 32-bit xmin value associated with the xmin snapshot. This is the value that is ultimately written and recorded on every row.
     * 
     */
    @JsonProperty("xmin_xid_value")
    public void setXminXidValue(Long xminXidValue) {
        this.xminXidValue = xminXidValue;
    }

    public XminStatus withXminXidValue(Long xminXidValue) {
        this.xminXidValue = xminXidValue;
        return this;
    }

    /**
     * The raw value of the xmin snapshot. If no wraparound has occurred, this should be the same as 2.
     * 
     */
    @JsonProperty("xmin_raw_value")
    public Long getXminRawValue() {
        return xminRawValue;
    }

    /**
     * The raw value of the xmin snapshot. If no wraparound has occurred, this should be the same as 2.
     * 
     */
    @JsonProperty("xmin_raw_value")
    public void setXminRawValue(Long xminRawValue) {
        this.xminRawValue = xminRawValue;
    }

    public XminStatus withXminRawValue(Long xminRawValue) {
        this.xminRawValue = xminRawValue;
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

    public XminStatus withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(XminStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("stateType");
        sb.append('=');
        sb.append(((this.stateType == null)?"<null>":this.stateType));
        sb.append(',');
        sb.append("numWraparound");
        sb.append('=');
        sb.append(((this.numWraparound == null)?"<null>":this.numWraparound));
        sb.append(',');
        sb.append("xminXidValue");
        sb.append('=');
        sb.append(((this.xminXidValue == null)?"<null>":this.xminXidValue));
        sb.append(',');
        sb.append("xminRawValue");
        sb.append('=');
        sb.append(((this.xminRawValue == null)?"<null>":this.xminRawValue));
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
        result = ((result* 31)+((this.xminRawValue == null)? 0 :this.xminRawValue.hashCode()));
        result = ((result* 31)+((this.numWraparound == null)? 0 :this.numWraparound.hashCode()));
        result = ((result* 31)+((this.stateType == null)? 0 :this.stateType.hashCode()));
        result = ((result* 31)+((this.xminXidValue == null)? 0 :this.xminXidValue.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof XminStatus) == false) {
            return false;
        }
        XminStatus rhs = ((XminStatus) other);
        return (((((((this.xminRawValue == rhs.xminRawValue)||((this.xminRawValue!= null)&&this.xminRawValue.equals(rhs.xminRawValue)))&&((this.numWraparound == rhs.numWraparound)||((this.numWraparound!= null)&&this.numWraparound.equals(rhs.numWraparound))))&&((this.stateType == rhs.stateType)||((this.stateType!= null)&&this.stateType.equals(rhs.stateType))))&&((this.xminXidValue == rhs.xminXidValue)||((this.xminXidValue!= null)&&this.xminXidValue.equals(rhs.xminXidValue))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
