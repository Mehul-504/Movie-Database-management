package DAO_files;

import java.util.List;

public abstract class AbstractMethordsUsers<K> {
   abstract void createObjects(K entity, int a);

   abstract List<K> getAllObjects();
}