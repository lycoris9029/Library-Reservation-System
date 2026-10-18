
package com.javabs.modules.library.repository;

import com.javabs.modules.library.domain.LibraryYuyue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
*
* @author 李寻欢
* @date 2023-04-03
**/
public interface LibraryYuyueRepository extends JpaRepository<LibraryYuyue, Integer>, JpaSpecificationExecutor<LibraryYuyue> {
}
