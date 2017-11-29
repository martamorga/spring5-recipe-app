package mmo.app.spring5recipeapp.domain

import java.math.BigDecimal
import javax.persistence.*

@Entity
class Ingredient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var description: String = ""

    var amount: BigDecimal = BigDecimal(0)

    @OneToOne(fetch = FetchType.EAGER)
    var unitOfMeasure: UnitOfMeasure = UnitOfMeasure()

    @ManyToOne
    var recipe: Recipe = Recipe()


}