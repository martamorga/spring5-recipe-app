package mmo.app.spring5recipeapp.domain

import javax.persistence.*

@Entity
class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var description: String = ""

    @ManyToMany(mappedBy = "categories")
    var recipes: Set<Recipe> = HashSet()

}