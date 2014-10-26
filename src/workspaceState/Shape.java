package workspaceState;

public class Shape {
    private String URI;

    public Shape (String path) {
        URI = path;
    }

    public String getPath () {
        return URI;
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof Shape)) {
            return false;
        }
        else {
            Shape other = (Shape) o;
            if (URI.equalsIgnoreCase(other.URI)) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
