
package com.javabs.modules.library.repository;

import com.javabs.modules.library.domain.LibrarySeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
*
* @author 李寻欢
* @date 2023-04-02
**/
public interface LibrarySeatRepository extends JpaRepository<LibrarySeat, Integer>, JpaSpecificationExecutor<LibrarySeat> {
}
