package service;

import model.Produto;
import java.util.HashSet;
import java.util.Set;

public class TagService {
    public void adicionarTag(Produto produto, String tag) {
        Set<String> tags = produto.getTags();
        if (tags == null) {
            tags = new HashSet<>();
        }
        tags.add(tag.toLowerCase());
        produto.setTags(tags);
    }
}
