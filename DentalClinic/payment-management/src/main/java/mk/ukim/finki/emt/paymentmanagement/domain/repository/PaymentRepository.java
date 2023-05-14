package mk.ukim.finki.emt.paymentmanagement.domain.repository;

import mk.ukim.finki.emt.paymentmanagement.domain.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
