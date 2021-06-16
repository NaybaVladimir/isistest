package org.example.isistest.repos;

import org.example.isistest.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepos extends JpaRepository<Position,String> {
    Position findPositionByName(String name);
}
