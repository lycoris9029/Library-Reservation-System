
package com.javabs.modules.library.repository;

import com.javabs.modules.library.domain.LibraryRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 
* @author 李寻欢
* @date 2023-04-02
**/
public interface LibraryRoomRepository extends JpaRepository<LibraryRoom, Integer>, JpaSpecificationExecutor<LibraryRoom> {
}
