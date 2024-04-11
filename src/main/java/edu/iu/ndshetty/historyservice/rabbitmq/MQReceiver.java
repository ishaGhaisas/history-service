package edu.iu.ndshetty.historyservice.rabbitmq;
import edu.iu.ndshetty.historyservice.model.PrimesRecord;
import edu.iu.ndshetty.historyservice.repository.PrimesHistoryRepository;
import org.springframework.stereotype.Component;

@Component
public class MQReceiver {
    private final PrimesHistoryRepository primesHistoryRepository;

    public MQReceiver(PrimesHistoryRepository primesHistoryRepository) {
        this.primesHistoryRepository = primesHistoryRepository;
    }

    @RabbitListener(queues={ "primes" })
    public void receiveMessage(@Payload String message) {
        System.out.println(message);
        Gson gson = new Gson();
        PrimesRecord primesRecord = gson
                .fromJson(message, PrimesRecord.class);
        primesHistoryRepository.save(primesRecord);
    }
}
