/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.chat.system;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class PersonalMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1382956059462999249L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PersonalMessage\",\"namespace\":\"com.chat.system\",\"fields\":[{\"name\":\"from\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"to\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"message\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   public java.lang.String from;
   public java.lang.String to;
   public java.lang.String message;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PersonalMessage() {}

  /**
   * All-args constructor.
   * @param from The new value for from
   * @param to The new value for to
   * @param message The new value for message
   */
  public PersonalMessage(java.lang.String from, java.lang.String to, java.lang.String message) {
    this.from = from;
    this.to = to;
    this.message = message;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return from;
    case 1: return to;
    case 2: return message;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: from = (java.lang.String)value$; break;
    case 1: to = (java.lang.String)value$; break;
    case 2: message = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'from' field.
   * @return The value of the 'from' field.
   */
  public java.lang.String getFrom() {
    return from;
  }

  /**
   * Sets the value of the 'from' field.
   * @param value the value to set.
   */
  public void setFrom(java.lang.String value) {
    this.from = value;
  }

  /**
   * Gets the value of the 'to' field.
   * @return The value of the 'to' field.
   */
  public java.lang.String getTo() {
    return to;
  }

  /**
   * Sets the value of the 'to' field.
   * @param value the value to set.
   */
  public void setTo(java.lang.String value) {
    this.to = value;
  }

  /**
   * Gets the value of the 'message' field.
   * @return The value of the 'message' field.
   */
  public java.lang.String getMessage() {
    return message;
  }

  /**
   * Sets the value of the 'message' field.
   * @param value the value to set.
   */
  public void setMessage(java.lang.String value) {
    this.message = value;
  }

  /**
   * Creates a new PersonalMessage RecordBuilder.
   * @return A new PersonalMessage RecordBuilder
   */
  public static com.chat.system.PersonalMessage.Builder newBuilder() {
    return new com.chat.system.PersonalMessage.Builder();
  }

  /**
   * Creates a new PersonalMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PersonalMessage RecordBuilder
   */
  public static com.chat.system.PersonalMessage.Builder newBuilder(com.chat.system.PersonalMessage.Builder other) {
    return new com.chat.system.PersonalMessage.Builder(other);
  }

  /**
   * Creates a new PersonalMessage RecordBuilder by copying an existing PersonalMessage instance.
   * @param other The existing instance to copy.
   * @return A new PersonalMessage RecordBuilder
   */
  public static com.chat.system.PersonalMessage.Builder newBuilder(com.chat.system.PersonalMessage other) {
    return new com.chat.system.PersonalMessage.Builder(other);
  }

  /**
   * RecordBuilder for PersonalMessage instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PersonalMessage>
    implements org.apache.avro.data.RecordBuilder<PersonalMessage> {

    private java.lang.String from;
    private java.lang.String to;
    private java.lang.String message;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.chat.system.PersonalMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.from)) {
        this.from = data().deepCopy(fields()[0].schema(), other.from);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.to)) {
        this.to = data().deepCopy(fields()[1].schema(), other.to);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.message)) {
        this.message = data().deepCopy(fields()[2].schema(), other.message);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing PersonalMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(com.chat.system.PersonalMessage other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.from)) {
        this.from = data().deepCopy(fields()[0].schema(), other.from);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.to)) {
        this.to = data().deepCopy(fields()[1].schema(), other.to);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.message)) {
        this.message = data().deepCopy(fields()[2].schema(), other.message);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'from' field.
      * @return The value.
      */
    public java.lang.String getFrom() {
      return from;
    }

    /**
      * Sets the value of the 'from' field.
      * @param value The value of 'from'.
      * @return This builder.
      */
    public com.chat.system.PersonalMessage.Builder setFrom(java.lang.String value) {
      validate(fields()[0], value);
      this.from = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'from' field has been set.
      * @return True if the 'from' field has been set, false otherwise.
      */
    public boolean hasFrom() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'from' field.
      * @return This builder.
      */
    public com.chat.system.PersonalMessage.Builder clearFrom() {
      from = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'to' field.
      * @return The value.
      */
    public java.lang.String getTo() {
      return to;
    }

    /**
      * Sets the value of the 'to' field.
      * @param value The value of 'to'.
      * @return This builder.
      */
    public com.chat.system.PersonalMessage.Builder setTo(java.lang.String value) {
      validate(fields()[1], value);
      this.to = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'to' field has been set.
      * @return True if the 'to' field has been set, false otherwise.
      */
    public boolean hasTo() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'to' field.
      * @return This builder.
      */
    public com.chat.system.PersonalMessage.Builder clearTo() {
      to = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'message' field.
      * @return The value.
      */
    public java.lang.String getMessage() {
      return message;
    }

    /**
      * Sets the value of the 'message' field.
      * @param value The value of 'message'.
      * @return This builder.
      */
    public com.chat.system.PersonalMessage.Builder setMessage(java.lang.String value) {
      validate(fields()[2], value);
      this.message = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'message' field has been set.
      * @return True if the 'message' field has been set, false otherwise.
      */
    public boolean hasMessage() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'message' field.
      * @return This builder.
      */
    public com.chat.system.PersonalMessage.Builder clearMessage() {
      message = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public PersonalMessage build() {
      try {
        PersonalMessage record = new PersonalMessage();
        record.from = fieldSetFlags()[0] ? this.from : (java.lang.String) defaultValue(fields()[0]);
        record.to = fieldSetFlags()[1] ? this.to : (java.lang.String) defaultValue(fields()[1]);
        record.message = fieldSetFlags()[2] ? this.message : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}