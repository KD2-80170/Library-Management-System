import React, { useState, useEffect } from "react";
import axios from "axios";

import 'bootstrap/dist/css/bootstrap.min.css';

function CategoryManager() {
    const [categories, setCategories] = useState([]);
    const [newCategory, setNewCategory] = useState({
        catName: "",
        description: ""
    });
    const [editCategory, setEditCategory] = useState(null);

    useEffect(() => {
        fetchCategories();
    }, []);

    const fetchCategories = () => {
        axios.get("http://localhost:8080/categories")
            .then(response => {
                setCategories(response.data);
            })
            .catch(error => {
                console.error("Error fetching categories:", error);
            });
    };

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        setNewCategory({
            ...newCategory,
            [name]: value
        });
    };

    const addCategory = () => {
        axios.post("http://localhost:8080/categories", newCategory)
            .then(response => {
                fetchCategories();
                resetNewCategory();
            })
            .catch(error => {
                console.error("Error adding category:", error);
            });
    };

    const updateCategory = () => {
        axios.put(`http://localhost:8080/categories/${editCategory.id}`, editCategory)
            .then(response => {
                fetchCategories();
                setEditCategory(null);
            })
            .catch(error => {
                console.error("Error updating category:", error);
            });
    };

    const deleteCategory = (id) => {
        axios.delete(`http://localhost:8080/categories/${id}`)
            .then(response => {
                fetchCategories();
            })
            .catch(error => {
                console.error("Error deleting category:", error);
            });
    };

    const editCategoryData = (category) => {
        setEditCategory(category);
    };

    const resetNewCategory = () => {
        setNewCategory({
            catName: "",
            description: ""
        });
    };

    return (
        <div className="container">
            <h2>Add New Category</h2>
            <div className="row">
                <div className="col">
                    <input className="form-control" type="text" name="catName" value={newCategory.catName} onChange={handleInputChange} placeholder="Category Name" />
                </div>
                <div className="col">
                    <input className="form-control" type="text" name="description" value={newCategory.description} onChange={handleInputChange} placeholder="Description" />
                </div>
                <div className="col">
                    <button className="btn btn-primary" onClick={addCategory}>Add Category</button>
                </div>
            </div>

            <h2>Categories</h2>
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {categories.map(category => (
                        <tr key={category.id}>
                            <td>{category.id}</td>
                            <td>{category.catName}</td>
                            <td>{category.description}</td>
                            <td>
                                <button className="btn btn-danger" onClick={() => deleteCategory(category.id)}>Delete</button>
                                <button className="btn btn-warning" onClick={() => editCategoryData(category)}>Edit</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {editCategory && (
                <div>
                    <h2>Edit Category</h2>
                    <div className="row">
                        <div className="col">
                            <input className="form-control" type="text" name="catName" value={editCategory.catName} onChange={(event) => setEditCategory({ ...editCategory, catName: event.target.value })} />
                        </div>
                        <div className="col">
                            <input className="form-control" type="text" name="description" value={editCategory.description} onChange={(event) => setEditCategory({ ...editCategory, description: event.target.value })} />
                        </div>
                        <div className="col">
                            <button className="btn btn-primary" onClick={updateCategory}>Update Category</button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

export default CategoryManager;
