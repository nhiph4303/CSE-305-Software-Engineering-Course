
public abstract class Document {
    protected String extension;
    protected boolean encryption;
    protected String content;
    protected String fileName;

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setEncryption(boolean encryption) {
        this.encryption = encryption;
    }

    public abstract void buildDoc();
}
