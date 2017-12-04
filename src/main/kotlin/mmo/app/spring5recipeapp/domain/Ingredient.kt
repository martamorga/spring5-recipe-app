package mmo.app.spring5recipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var description: String = ""

    var amount: BigDecimal = BigDecimal(0)

    @OneToOne(fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    var unitOfMeasure: UnitOfMeasure? = null

    @ManyToOne
    var recipe: Recipe? = null


}