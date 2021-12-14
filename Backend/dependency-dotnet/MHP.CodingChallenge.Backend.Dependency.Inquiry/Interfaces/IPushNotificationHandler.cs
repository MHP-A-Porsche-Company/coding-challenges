namespace MHP.CodingChallenge.Backend.Dependency.Inquiry.Interfaces
{
    public interface IPushNotificationHandler
    {
        void SendNotification(Dependency.Inquiry.Inquiry inquiry);
    }
}