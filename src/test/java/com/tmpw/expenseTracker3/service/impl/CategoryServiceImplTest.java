package com.tmpw.expenseTracker3.service.impl;

import com.tmpw.expenseTracker3.model.Category;
import com.tmpw.expenseTracker3.model.User;
import com.tmpw.expenseTracker3.repository.CategoryRepository;
import com.tmpw.expenseTracker3.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    @Mock
    private UserService userService;

    @Test
    void testSaveCategory() {
        User user = new User();
        user.setCreatedAt(mock(Timestamp.class));
        user.setId(123L);
        user.setPassword("iloveyou");
        user.setUpdatedAt(mock(Timestamp.class));
        user.setUsername("janedoe");

        Category category = new Category();
        category.setId(123L);
        category.setName("Name");
        category.setUser(user);

        when(categoryRepository.save((Category) any())).thenReturn(category);

        User user1 = new User();
        user1.setCreatedAt(mock(Timestamp.class));
        user1.setId(123L);
        user1.setPassword("iloveyou");
        user1.setUpdatedAt(mock(Timestamp.class));
        user1.setUsername("janedoe");

        when(userService.getLoggedInUser()).thenReturn(user1);

        User user2 = new User();
        user2.setCreatedAt(mock(Timestamp.class));
        user2.setId(123L);
        user2.setPassword("iloveyou");
        user2.setUpdatedAt(mock(Timestamp.class));
        user2.setUsername("janedoe");

        Category category1 = new Category();
        category1.setId(123L);
        category1.setName("Name");
        category1.setUser(user2);

        assertSame(category, categoryServiceImpl.saveCategory(category1));

        verify(categoryRepository).save((Category) any());
        verify(userService).getLoggedInUser();

        assertSame(user1, category1.getUser());
    }
}

